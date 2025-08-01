<template>
  <div class="border p-4 mb-4">
    <h3 class="text-lg font-semibold">{{ post.title }}</h3>
    <p>{{ post.content }}</p>
    <div class="flex gap-2 mt-2">
      <router-link :to="`/edit-post/${post.id}`" class="text-blue-600">✏️ 編輯</router-link>
      <button @click="del" class="text-red-600">🗑 刪除</button>
    </div>
  </div>
</template>

<script setup>
import axios from 'axios'
import { defineProps, defineEmits } from 'vue'

const props = defineProps({ post: Object })
const emit = defineEmits(['refresh'])

const del = async () => {
  await axios.delete(`/posts/${props.post.id}`)
  emit('refresh')
}
</script>
