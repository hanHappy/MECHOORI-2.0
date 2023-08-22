<script setup>
import { ref } from 'vue';


let invalidTopCategoryId = ref()

function checkVaild(){
    if(!(1 <= category.topCategoryId && category.topCategoryId <= 6))
        invalidTopCategoryId.value = true
    else
        invalidTopCategoryId.value = false
}

let category = {
    topCategoryId: null,
    name: null
}

function saveHandler() {
    fetch('http://localhost:8080/api/category/add', {
        method: 'post',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(category)
    })
    .then(response => {
        if(!response.ok)
            throw new Error("추가 실패")
        return response.json()
    })
    .then(category => {
        console.log(category);
    })
    .catch(e => {
        console.log(e);
    })
}
</script>

<template>
    <main class="admin-main">

        <section class="form-section">
            <div class="form-container">
                <div class="form-wrap">
                    <label>상위 카테고리 ID</label>
                    <input v-model="category.topCategoryId" @input="checkVaild" type="text" class="placeholder-effect" placeholder="ex) 1" required />
                </div>
                <div class="form-wrap">
                    <label>카테고리 이름</label>
                    <input v-model="category.name" type="text" class="placeholder-effect" placeholder="ex) 한식" required />
                </div>
                <div v-show="invalidTopCategoryId">유효하지 않은 아이디</div>
                <button class="button button-1 btn-submit" @click="saveHandler">저장</button>
            </div>
        </section>
        
    </main>
</template>

<style scoped>
@import url(@/assets/css/admin/restaurant.css);
</style>