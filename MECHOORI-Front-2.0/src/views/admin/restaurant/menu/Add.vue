<script setup>
import { useRoute, useRouter } from 'vue-router'

let menu = {
    restaurantId: useRoute().params.id,
    name: null,
    price: null
}

const router = useRouter()

function saveHandler(){
    fetch('http://localhost:8080/api/menu/add', {
        headers: {
            'Content-Type':'application/json'
        },
        method: 'post',
        body: JSON.stringify(menu)
    })
    .then(response => {
        if(!response.ok)
            throw new Error("업데이트 실패")
        return response.json()
    })
    .then(
        router.push(`/admin/restaurant/${menu.restaurantId}/menu`)
    )
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
                    <label>식당 ID</label>
                    <input v-model="menu.restaurantId" type="text" class="placeholder-effect" placeholder="ex) 160" required />
                </div>
                <div class="form-wrap">
                    <label>메뉴명</label>
                    <input v-model="menu.name" type="text" class="placeholder-effect" placeholder="ex) 짜장면" required />
                </div>
                <div class="form-wrap">
                    <label>가격</label>
                    <input v-model="menu.price" type="text" class="placeholder-effect" placeholder="ex) 6000" required />
                </div>
                <button class="button button-1 btn-submit" @click="saveHandler">저장</button>
            </div>
        </section>
        
    </main>
</template>

<style scoped>
@import url(@/assets/css/admin/restaurant.css);
</style>