<script setup>
import { onMounted, ref } from 'vue';

onMounted(()=>{
    fetch('http://localhost:8080/api/category/list')
    .then(response => {
        if(!response.ok)
            throw new Error("리스트가 없어요")
        return response.json()
    })
    .then(list_ => {
        list.value = list_
    })
    .catch(e => {
        console.log(e)
    })
})

let list = ref()

function deleteHandler(id, index){
    fetch(`http://localhost:8080/api/category/${id}`, {
        method: 'delete'
    })
    .then(response => {
        if(!response.ok)
            throw new Error("삭제 실패")
        return response.json()
    })
    .then(deletedCategory => {
        list.value.splice(index, 1)
    })
    .catch(e => {
        console.log(e);
    })
}

</script>

<template>
    <main class="admin-main">
        <!-- 검색바 -->
        <div class="search-input-wrap">
            <input type="text" class="input placeholder-effect" placeholder="카테고리 검색">
            <button class="button icon icon-search"></button>
        </div>

        <section class="list-section">
            <h1 class="d-none">카테고리 리스트</h1>
            <nav class="column-wrap">
                <ul>
                    <li>ID</li>
                    <li>상위 카테고리 ID</li>
                    <li>카테고리명</li>
                    <li><router-link to="category/add" class="button button-13">＋</router-link></li>
                </ul>
            </nav>
            <div class="list">
                <section class="data content" v-for="c, index in list" :key="index">
                    <p>{{ c.id }}</p>
                    <p>{{ c.topCategoryId }}</p>
                    <p>{{ c.name }}</p>
                    <div class="btns-wrap">
                        <router-link :to="`category/${c.id}/edit`" class="button button-14 btn-edit">EDIT</router-link>
                        <button class="button button-14 btn-delete" @click="deleteHandler(c.id, index)">DEL</button>
                    </div>
                </section>
            </div>
        </section>
    </main>
</template>

<style scoped>
@import url(@/assets/css/admin/restaurant.css);
</style>
