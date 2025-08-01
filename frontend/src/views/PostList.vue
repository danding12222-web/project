<template>
  <div class="p-4">
    <h2 class="text-xl font-bold mb-4">所有文章</h2>
    <router-link to="/create-post" class="text-blue-500">➕ 新增文章</router-link>
    <div v-if="posts.length">
      <PostCard v-for="post in posts" :key="post.id" :post="post" @refresh="fetchPosts" />
    </div>
    <div v-else>尚無文章</div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import axios from 'axios'
import PostCard from '@/components/PostCard.vue'

const posts = ref([])

const fetchPosts = async () => {
  const res = await axios.get('/posts')
  posts.value = res.data
}

onMounted(fetchPosts)
</script>
