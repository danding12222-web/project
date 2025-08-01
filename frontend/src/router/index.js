import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import PostList from '@/views/PostList.vue'
import CreatePost from '@/views/CreatePost.vue'
import EditPost from '@/views/EditPost.vue'
import LoginView from '../views/LoginView.vue'
import RegisterPage from '../views/RegisterPage.vue'
import axios from 'axios'

const routes = [
  { path: '/', name: 'home', component: HomeView },
  { path: '/register', name: 'register', component: RegisterPage },
  { path: '/login', name: 'login', component: LoginView },
  { path: '/create-post',name: 'create', component: CreatePost },
  { path: '/edit-post/:id', component: EditPost },
  { path: '/', component: PostList },
]

const router = createRouter({
  history: createWebHistory(),
  routes,
})


export default router
