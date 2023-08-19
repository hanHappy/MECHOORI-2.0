<script setup>
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
                <section class="data content">
                    <p></p>
                    <p></p>
                    <p></p>
                    <div class="btns-wrap">
                        <router-link to="category/edit" class="button button-14 btn-edit">EDIT</router-link>
                        <button class="button button-14 btn-delete">DEL</button>
                    </div>
                </section>
            </div>
        </section>
    </main>
</template>

<style scoped>
@import url(@/assets/css/admin/restaurant.css);
</style>
