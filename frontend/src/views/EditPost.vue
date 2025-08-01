<template>
  <div class="p-4">
    <h2 class="text-xl font-bold mb-4">編輯文章</h2>
    <form @submit.prevent="submit">
      <input v-model="title" class="border p-2 w-full mb-2" />
      <textarea v-model="content" class="border p-2 w-full mb-2"></textarea>
      <button class="bg-green-500 text-white px-4 py-2 rounded">更新</button>
    </form>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import axios from 'axios'
import { useRoute, useRouter } from 'vue-router'

const route = useRoute()
const router = useRouter()

const title = ref('')
const content = ref('')

const fetchPost = async () => {
  const res = await axios.get(`/posts/${route.params.id}`)
  title.value = res.data.title
  content.value = res.data.content
}

const submit = async () => {
  await axios.put(`/posts/${route.params.id}`, {
    title: title.value,
    content: content.value
  })
  router.push('/')
}

onMounted(fetchPost)
</script>
