<!-- =============== 관리자 Layout =============== -->

<script setup>
import Header from '../Header.vue'
import Aside from './Aside.vue'
</script>

<template>
    <Header />

    <div class="aside-main-wrap">
        <Aside />

        <!-- App에도 router가 있고 여기도 있음 = router 중첩 -->
        <router-view></router-view>
    </div>
</template>

<style scoped>
/* @ : src directory */
/* assets 폴더 : 번역이 됨 => 경량화된 배포가 가능 */
/* 번들링으로 한 번에 가기 때문에 따로 불러오면서 발생하는 문제점(css가 깨지는 등) 해결 */

/* 이미지는 assets보다 public에 두는 것이 선호된다 */
.aside-main-wrap {
    display: flex;
}
</style>