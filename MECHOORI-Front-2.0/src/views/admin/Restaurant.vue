<script setup>
import { onMounted, reactive } from 'vue';

let model = reactive({
    list: [],
    categoryList: [],
    searchWord: null
})

onMounted(()=>{
    
    fetch('http://localhost:8080/restaurant/list')
    .then(response => response.json())
    .then(list => {
        model.list = list
    })

    fetch('http://localhost:8080/api/category/list')
    .then(response => {
        if(!response.ok)
            throw new Error("카테고리를 찾을 수 없습니다")
        return response.json()
    })
    .then(categoryList_ => {
        model.categoryList = categoryList_
    })
    .catch(e => {
        console.log(e)
    })
})

function categoryClickHandler(cid){
    fetch(`http://localhost:8080/restaurant/list?c=${cid}`)
    .then(response => {
        if(!response.ok)
            throw new Error("목록을 찾을 수 없습니다")
        return response.json()
    })
    .then(list => {
        model.list = list
    })
    .catch(e => {
        console.log(e)
    })
}

// 필터링 ----------------------------
let filterId
function filteringHandler(){
    let url = `http://localhost:8080/restaurant/list?f=${filterId}`
    console.log(url);
    fetch(url)
    .then(response => {
        if(!response.ok)
            throw new Error("목록을 찾을 수 없습니다")
        return response.json()
    })
    .then(list => {
        model.list = list
    })
    .catch(e => {
        console.log(e)
    })
    
}

// 검색 -------------------------------
function searchHandler() {
    fetch(`http://localhost:8080/restaurant/list?q=${model.searchWord}`)
    .then(response => response.json())
    .then(list => {
        model.list = list
    })
}

let deleteId = null

function deleteHandler() {
    fetch(`http://localhost:8080/restaurant/${deleteId}`, {
        method: 'delete',
    })
    .then(response => response.json())
    .then(result => {
        console.log(result);
    })
}

function deleteUiHandler(index) {
    model.list.splice(index, 1)
}

</script>

<template>
    <main class="admin-main">
        <!-- 검색바 -->
        <div class="search-input-wrap">
            <input type="text" class="input placeholder-effect" placeholder="식당 검색" v-model="model.searchWord" @keydown.enter="searchHandler">
            <button class="button icon icon-search"></button>
        </div>

        <div class="filter-container">
            <div class="category-container">
                <ul>
                    <li><button>전체</button></li>
                    <li 
                        v-for="c, index in model.categoryList" 
                        :key="index"
                        @click="categoryClickHandler(c.id)">
                        <button>{{ c.name }}</button>
                    </li>
                </ul>
            </div>
            <select  
                class="filter" 
                @change="filteringHandler" 
                v-model="filterId">
                <option value="">전체</option>
                <option value="1">가성비순</option>
                <option value="2">가격낮은순</option>
                <option value="3">가격높은순</option>
                <option value="4">좋아요순</option>
                <option value="5">평가순</option>
            </select>
        </div>

        <section class="list-section">
            <h1 class="d-none">식당 리스트</h1>
            <nav class="column-wrap">
                <ul>
                    <li>id</li>
                    <li>카테고리</li>
                    <li>식당명</li>
                    <li>이미지</li>
                    <li>소개</li>
                    <li>주소</li>
                    <li>영업시간</li>
                    <li>연락처</li>
                    <li><router-link to="/admin/restaurant/add" class="button button-13">＋</router-link></li>
                </ul>
            </nav>
            <div class="list">
                <section class="data content" v-for="(r, index) in model.list" :key="index">
                    <p>{{ r.id }}</p>
                    <p>{{ r.categoryId }}</p>
                    <p>{{ r.name }}</p>
                    <p>{{ r.img }}</p>
                    <p>{{ r.intro }}</p>
                    <p>{{ r.address }}</p>
                    <p>{{ r.operatingTime }}</p>
                    <p>{{ r.contactNumber }}</p>
                    <div class="btns-wrap">
                        <router-link :to="`/admin/restaurant/${r.id}/menu`" class="button button-14 btn-menu">MENU</router-link>
                        <router-link :to="`/admin/restaurant/edit/${r.id}`" class="button button-14 btn-edit">EDIT</router-link>
                        <button class="button button-14 btn-delete" @click="deleteId=r.id; deleteHandler(); deleteUiHandler(index)">DEL</button>
                    </div>
                </section>
            </div>
        </section>
        <div class="page-container">
            <ul>
                <li>1</li>
            </ul>
        </div>
    </main>
</template>

<style scoped>
@import url(@/assets/css/admin/restaurant.css);
</style>