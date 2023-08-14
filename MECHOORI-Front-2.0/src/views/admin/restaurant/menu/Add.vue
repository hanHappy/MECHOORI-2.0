<script setup>
</script>

<template>
    <main class="admin-main">

        <section class="form-section">
            <div class="form-container">
                <div class="form-wrap">
                    <label>식당 ID</label>
                    <input type="text" class="placeholder-effect" placeholder="ex) 160" required />
                </div>
                <div class="form-wrap">
                    <label>메뉴명</label>
                    <input type="text" class="placeholder-effect" placeholder="ex) 짜장면" required />
                </div>
                <div class="form-wrap">
                    <label>가격</label>
                    <input type="text" class="placeholder-effect" placeholder="ex) 6000" required />
                </div>
                <button class="button button-1 btn-submit">저장</button>
            </div>
        </section>
        
    </main>
</template>

<style scoped>
@import url(@/assets/css/admin/restaurant.css);
</style>