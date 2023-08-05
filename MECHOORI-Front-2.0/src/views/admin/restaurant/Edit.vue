<script setup>
import { onMounted, reactive } from 'vue'
import { useRoute } from 'vue-router'

let model = reactive({
    restaurant: null,
    loaded: false
})

onMounted(()=>{
    let restaurantId = useRoute().params.id

    fetch(`http://localhost:8080/restaurant/${restaurantId}`)
    .then(response => response.json())
    .then(restaurant_ => {
        model.restaurant = restaurant_
        model.loaded = true
    })
})

function saveHandler() {

    fetch('http://localhost:8080/restaurant/edit', {
        method: 'put',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(model.restaurant)
    })
    .then(response => response.json())
    .then(result => {
        console.log(result);
    })
}


</script>

<template>
    <main class="admin-main">

        <section class="form-section" >
            <div class="form-container" v-if="model.loaded">
                <div class="form-wrap">
                    <label>ID</label>
                    <input v-model="model.restaurant.id" type="text" class="placeholder-effect" placeholder="" readonly />
                </div>
                <div class="form-wrap">
                    <label>식당명</label>
                    <input v-model="model.restaurant.name" type="text" class="placeholder-effect" placeholder=""  />
                </div>
                <div class="form-wrap">
                    <label>카테고리</label>
                    <input v-model="model.restaurant.categoryId" type="text" class="placeholder-effect" placeholder=""  />
                </div>
                <div class="form-wrap">
                    <label>이미지</label>
                    <input v-model="model.restaurant.img" type="text" class="placeholder-effect" placeholder=""  />
                </div>
                <div class="form-wrap">
                    <label>주소</label>
                    <input v-model="model.restaurant.address" type="text" class="placeholder-effect" placeholder=""  />
                </div>
                <div class="form-wrap">
                    <label>소개</label>
                    <input v-model="model.restaurant.intro" type="text" class="placeholder-effect" placeholder=""  />
                </div>
                <div class="form-wrap">
                    <label>연락처</label>
                    <input v-model="model.restaurant.contactNumber" type="text" class="placeholder-effect" placeholder=""  />
                </div>
                <div class="form-wrap">
                    <label>영업 시간</label>
                    <input v-model="model.restaurant.operatingTime" type="text" class="placeholder-effect" placeholder=""  />
                </div>
                <button class="button button-1 btn-submit" @click="saveHandler">저장</button>
            </div>
        </section>
        
    </main>
</template>

<style scoped>
@import url(@/assets/css/admin/restaurant.css);
</style>