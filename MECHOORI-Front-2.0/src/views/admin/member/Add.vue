<script setup>
</script>

<template>
    <main class="admin-main">

        <section class="form-section">
            <div class="form-container">
                <div class="form-wrap">
                    <label>ROLE ID</label>
                    <input type="text" class="placeholder-effect" placeholder="ex) 1" required />
                </div>
                <div class="form-wrap">
                    <label>이름</label>
                    <input type="text" class="placeholder-effect" placeholder="ex) 김메추리" required />
                </div>
                <div class="form-wrap">
                    <label>닉네임</label>
                    <input type="text" class="placeholder-effect" placeholder="ex) 메추로" required />
                </div>
                <div class="form-wrap">
                    <label>이메일</label>
                    <input type="text" class="placeholder-effect" placeholder="ex) mechoori@gmail.com" required />
                </div>
                <div class="form-wrap">
                    <label>비밀번호</label>
                    <input type="text" class="placeholder-effect" placeholder="ex) 8자리 이상" required />
                </div>
                <div class="review-image-wrap">
                    <label for="review-image" id="review-image-label">
                        <div class="btn-upload">메뉴 사진 첨부</div>
                    </label>
                    <input id="review-image" class="d-none" type="file" name="image" accept="image/*">
                </div>
                <button class="button button-1 btn-submit">저장</button>
            </div>
        </section>
        
    </main>
</template>

<style scoped>
@import url(@/assets/css/admin/restaurant.css);
</style>