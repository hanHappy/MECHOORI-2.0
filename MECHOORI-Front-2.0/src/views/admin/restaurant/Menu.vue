<script setup>
import { onMounted, reactive, ref } from 'vue'
import { useRoute } from 'vue-router'

let restaurantId = useRoute().params.id

onMounted(() => {
    fetch(`http://localhost:8080/restaurant/${restaurantId}/menu`)
    .then(response => {
        if(!response.ok)
            throw new Error("오류예요")
        return response.json()
    })
    .then(menuList => {
        list.value = menuList
    })
    .catch(e => {
    })
})

let list = ref([])

function deleteHandler(id, index){
    fetch(`http://localhost:8080/api/menu/${id}`, {
        method: 'delete'
    })
    .then(response => response.json())
    .then(result => {
        if(result)
            list.value.splice(index, 1)
    })
}

</script>

<template>
    <main class="admin-main">
        <!-- 검색바 -->
        <div class="search-input-wrap">
            <input type="text" class="input placeholder-effect" placeholder="메뉴 검색">
            <button class="button icon icon-search"></button>
        </div>

        <section class="list-section">
            <h1 class="d-none">메뉴 리스트</h1>
            <nav class="column-wrap">
                <ul>
                    <li>ID</li>
                    <li>식당 ID</li>
                    <li>메뉴명</li>
                    <li>가격</li>
                    <li><router-link to="menu/add" class="button button-13">＋</router-link></li>
                </ul>
            </nav>
            <div class="list">
                <section class="data content" v-for="m, index in list" :key="index">
                    <p>{{ m.id }}</p>
                    <p>{{ m.restaurantId }}</p>
                    <p>{{ m.name }}</p>
                    <p>{{ m.price }}</p>
                    <div class="btns-wrap">
                        <!-- restaurant/160/menu/1/edit -->
                        <router-link :to="`menu/${m.id}/edit`" class="button button-14 btn-edit">EDIT</router-link>
                        <button class="button button-14 btn-delete" @click="deleteHandler(m.id, index)">DEL</button>
                    </div>
                </section>
            </div>
        </section>
    </main>
</template>

<style scoped>
@import url(@/assets/css/admin/restaurant.css);
</style>
