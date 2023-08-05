<script setup>
</script>

<template>
    <aside>
        <h1 class="d-none">Aside</h1>
        <nav>
            <ul>
                <li><router-link class="menu" to="/admin/member">회원 관리</router-link></li>
                <li><router-link class="menu" to="/admin/restaurant">식당 관리</router-link></li>
                <li><router-link class="menu" to="/admin/category">카테고리 관리</router-link></li>
            </ul>
        </nav>
    </aside>
</template>

<style scoped>
@import url(@/assets/css/admin/components/aside.css);
</style>