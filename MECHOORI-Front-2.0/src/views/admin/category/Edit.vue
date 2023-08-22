<script setup>
import { onMounted, ref } from 'vue';
import { useRoute } from 'vue-router';

let id = useRoute().params.id

onMounted(() => {
    fetch(`http://localhost:8080/api/category/${id}`)
    .then(response => {
        if(!response.ok)
            throw new Error("데이터가 없어요")
        return response.json()
    })
    .then(c => {
        category.value = c
    })
    .catch(e => {
        console.log(e);
    })
})

let category = ref()

function saveHandler(){
    fetch('http://localhost:8080/api/category/edit', {
        headers: {
            'Content-Type': 'application/json',
        },
        method: 'put',
        body: JSON.stringify(category.value)
    })
    .then(response => {
        if(!response.ok)
            throw new Error("업뎃 실패")
        return response.json()
    })
    .then(category => {
        category.value = category
        response.value = '업뎃 성공'
    })
    .catch(e => {
        response.value = e
    })
}

let response = ref()

</script>

<template>
    <main class="admin-main">

        <section class="form-section">
            <div class="form-container" v-if="category">
                <div class="form-wrap">
                    <label>ID</label>
                    <input v-model="category.id" type="text" class="placeholder-effect" readonly/>
                </div>
                <div class="form-wrap">
                    <label>상위 카테고리 ID</label>
                    <input v-model="category.topCategoryId" type="text" class="placeholder-effect" />
                </div>
                <div class="form-wrap">
                    <label>카테고리명</label>
                    <input v-model="category.name" type="text" class="placeholder-effect" />
                </div>
                <div v-show="response">{{ response }}</div>
                <button class="button button-1 btn-submit" @click="saveHandler">저장</button>
            </div>
        </section>
        
    </main>
</template>

<style scoped>
@import url(@/assets/css/admin/restaurant.css);
</style>