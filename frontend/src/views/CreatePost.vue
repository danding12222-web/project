<template>
  <div class="p-4">
    <h2 class="text-xl font-bold mb-4">新增文章</h2>
    <form @submit.prevent="submit">
      <input v-model="title" placeholder="標題" class="border p-2 w-full mb-2" />
      <textarea v-model="content" placeholder="內容" class="border p-2 w-full mb-2"></textarea>
      <button class="bg-blue-500 text-white px-4 py-2 rounded">送出</button>
    </form>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import axios from 'axios'
import { useRouter } from 'vue-router'

const title = ref('')
const content = ref('')
const router = useRouter()

const submit = async () => {
  await axios.post('/posts', { title: title.value, content: content.value })
  router.push('/')
}
</script>
