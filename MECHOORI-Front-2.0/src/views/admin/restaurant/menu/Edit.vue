<script setup>
import { onMounted, ref } from 'vue'
import { useRoute, useRouter } from 'vue-router'

let menuId = useRoute().params.mid
let restaurantId = useRoute().params.id

onMounted(()=> {
    fetch(`http://localhost:8080/api/menu/${menuId}`)
    .then(response => {
        if(!response.ok)
            throw new Error("메뉴가 없습니다")
        return response.json()
    })
    .then(menu_ => {
        menu.value = menu_
    })
    .catch(e => {
        console.log(e);
    })
})

let menu = ref()

const router = useRouter()

function saveHandler() {
    fetch(`http://localhost:8080/api/menu/${menu.value.id}`, {
        headers: {
            'Content-Type':'application/json'
        },
        method: 'put',
        body: JSON.stringify(menu.value)
    })
    .then(response => {
        if(!response.ok)
            throw new Error("업데이트 실패")
        return response.json()
    })
    .then(menu_ => {
        router.push(`/admin/restaurant/${restaurantId}/menu`)
    })
    .catch(e => {
        console.log(e);
    })

}

</script>

<template>
    <main class="admin-main">

        <section class="form-section">
            <div class="form-container" v-if="menu">
                <div class="form-wrap">
                    <label>ID</label>
                    <input type="text" v-model="menu.id" class="placeholder-effect" readonly />
                </div>
                <div class="form-wrap">
                    <label>식당 ID</label>
                    <input type="text" v-model="menu.restaurantId" class="placeholder-effect" />
                </div>
                <div class="form-wrap">
                    <label>메뉴명</label>
                    <input type="text" v-model="menu.name" class="placeholder-effect" />
                </div>
                <div class="form-wrap">
                    <label>가격</label>
                    <input type="text" v-model="menu.price" class="placeholder-effect" />
                </div>
                <button class="button button-1 btn-submit" @click="saveHandler">저장</button>
            </div>
        </section>

    </main>
</template>

<style scoped>
@import url(@/assets/css/admin/restaurant.css);
</style>