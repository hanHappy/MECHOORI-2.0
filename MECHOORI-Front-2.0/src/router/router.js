import { createRouter, createWebHistory } from 'vue-router'

import Home from '../views/Home.vue'

import AdminDashboard from '../views/admin/Dashboard.vue'

import AdminLayout from '../components/admin/Layout.vue'

import AdminRestaurant from '../views/admin/Restaurant.vue'
import RestaurantAdd from '../views/admin/restaurant/Add.vue'
import RestaurantEdit from '../views/admin/restaurant/Edit.vue'

import AdminMenu from '../views/admin/restaurant/Menu.vue'
import MenuAdd from '../views/admin/restaurant/menu/Add.vue'
import MenuEdit from '../views/admin/restaurant/menu/Edit.vue'

import AdminCategory from '../views/admin/Category.vue'
import CategoryAdd from '../views/admin/category/Add.vue'
import CategoryEdit from '../views/admin/category/Edit.vue'

import AdminMember from '../views/admin/Member.vue'
import MemberAdd from '../views/admin/member/Add.vue'
import MemberEdit from '../views/admin/member/Edit.vue'


import '@/assets/css/reset.css'
import '@/assets/css/style.css'
import '@/assets/css/util.css'
import '@/assets/css/common/icon.css'
import '@/assets/css/common/form.css'
import '@/assets/css/common/button.css'
import '@/assets/css/admin/style.css'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      // Component를 직접 import하여 routing 하는 방식
      // Application을 처음 로드할 때 이 component가 함께 로드됨
      // 따라서 초기 로딩 시간이 늘어남
      // 그러므로 자주 방문되는 View 혹은 크기가 작은 View에 적합함
      component: Home
    },
    {
      path: '/admin',
      name: 'admin',
      component: AdminLayout,
      children: [
        { path: 'dashboard', component: AdminDashboard },
        { path: 'member', component: AdminMember },

        { path: 'restaurant', component: AdminRestaurant},
        { path: 'restaurant/add', component: RestaurantAdd },
        { path: 'restaurant/edit/:id', component: RestaurantEdit },
        
        { path: 'restaurant/:id/menu', component: AdminMenu },
        { path: 'restaurant/:id/menu/add', component: MenuAdd },
        { path: 'restaurant/:id/menu/:mid/edit', component: MenuEdit },

        { path: 'category', component: AdminCategory },
        { path: 'category/add', component: CategoryAdd },
        { path: 'category/:id/edit', component: CategoryEdit },

        { path: 'member', component: AdminMember },
        { path: 'member/add', component: MemberAdd },
        { path: 'member/edit', component: MemberEdit },
      ]
    }
  ]
})

export default router
