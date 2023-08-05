<script setup>
</script>

<template>
    <header>
        <h1 class="d-none">Header</h1>
        <nav>
            <div class="btn-admin">
                <router-link to="/admin/dashboard" class="icon icon-logo">관리자</router-link>
            </div>
        </nav>
    </header>
</template>

<style scoped>
@import url(@/assets/css/components/header.css);
</style>