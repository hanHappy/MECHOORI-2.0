<script setup>
</script>

<template>
    <main class="admin-main">

        <section class="form-section">
            <div class="form-container">
                <div class="form-wrap">
                    <label>상위 카테고리 ID</label>
                    <input type="text" class="placeholder-effect" placeholder="ex) 1" required />
                </div>
                <div class="form-wrap">
                    <label>한식</label>
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