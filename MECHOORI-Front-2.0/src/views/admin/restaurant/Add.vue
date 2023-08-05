<template>
    <main class="admin-main">

        <section class="form-section">
            <div class="form-container">
                <div class="form-wrap">
                    <label>식당명</label>
                    <input type="text" class="placeholder-effect" placeholder="ex) 짜장상회" required />
                </div>
                <div class="form-wrap">
                    <label>카테고리</label>
                    <input type="text" class="placeholder-effect" placeholder="ex) 중식" required />
                </div>
                <div class="form-wrap">
                    <label>이미지</label>
                    <input type="text" class="placeholder-effect" placeholder="ex) 짜장상회.jpg" required />
                </div>
                <div class="form-wrap">
                    <label>주소</label>
                    <input type="text" class="placeholder-effect" placeholder="ex) 백범로 24" required />
                </div>
                <div class="form-wrap">
                    <label>소개</label>
                    <input type="text" class="placeholder-effect" placeholder="ex) 근본 중식" required />
                </div>
                <div class="form-wrap">
                    <label>연락처</label>
                    <input type="text" class="placeholder-effect" placeholder="ex) 02-000-0000" required />
                </div>
                <div class="form-wrap">
                    <label>영업 시간</label>
                    <input type="text" class="placeholder-effect" placeholder="ex) 평일 09:00 - 22:00" required />
                </div>
                <button class="button button-1 btn-submit" disabled>저장</button>
            </div>
        </section>
        
    </main>
</template>

<style scoped>
@import url(@/assets/css/admin/restaurant.css);
</style>