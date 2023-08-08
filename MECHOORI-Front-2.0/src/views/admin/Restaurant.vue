<script setup>
import { onMounted, reactive } from 'vue';

let model = reactive({
    list: [],
    searchWord: null
})

onMounted(()=>{
    
    fetch('http://localhost:8080/restaurant/list')
    .then(response => response.json())
    .then(list => {
        model.list = list
        
    })
    
})

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

        <section class="restaurant-list-section">
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
            <div class="restaurant-list">
                <section class="data restaurant" v-for="(r, index) in model.list" :key="index">
                    <p>{{ r.id }}</p>
                    <p>{{ r.categoryId }}</p>
                    <p>{{ r.name }}</p>
                    <p>{{ r.img }}</p>
                    <p>{{ r.intro }}</p>
                    <p>{{ r.address }}</p>
                    <p>{{ r.operatingTime }}</p>
                    <p>{{ r.contactNumber }}</p>
                    <div class="btns-wrap">
                        <router-link to="" class="button button-14 btn-menu">MENU</router-link>
                        <router-link :to="`/admin/restaurant/edit/${r.id}`" class="button button-14 btn-edit">EDIT</router-link>
                        <button class="button button-14 btn-delete" @click="deleteId=r.id; deleteHandler(); deleteUiHandler(index)">DEL</button>
                    </div>
                </section>
            </div>
        </section>
    </main>
</template>

<style scoped>
@import url(@/assets/css/admin/restaurant.css);
</style>