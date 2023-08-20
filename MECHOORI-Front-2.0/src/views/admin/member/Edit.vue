<script setup>
</script>

<template>
    <main class="admin-main">

        <section class="form-section">
            <div class="form-container">
                <div class="form-wrap">
                    <label>ROLE ID</label>
                    <input type="text" class="placeholder-effect" readonly />
                </div>
                <div class="form-wrap">
                    <label>이름</label>
                    <input type="text" class="placeholder-effect"/>
                </div>
                <div class="form-wrap">
                    <label>닉네임</label>
                    <input type="text" class="placeholder-effect"/>
                </div>
                <div class="form-wrap">
                    <label>이메일</label>
                    <input type="text" class="placeholder-effect"/>
                </div>
                <div class="form-wrap">
                    <label>비밀번호</label>
                    <input type="text" class="placeholder-effect"/>
                </div>
                <div class="form-wrap">
                    <label>프사</label>
                    <input type="text" class="placeholder-effect"/>
                </div>
                <div class="form-wrap">
                    <label>로그인 타입 ID</label>
                    <input type="text" class="placeholder-effect"/>
                </div>
                <button class="button button-1 btn-submit">저장</button>
            </div>
        </section>
        
    </main>
</template>

<style scoped>
@import url(@/assets/css/admin/restaurant.css);
</style>