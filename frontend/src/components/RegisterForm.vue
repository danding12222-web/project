<template>
  <div class="max-w-md mx-auto p-4 bg-white rounded shadow">
    <h2 class="text-xl font-bold mb-4">註冊帳號</h2>
    <form @submit.prevent="handleRegister">
      <div class="mb-3">
        <label class="block mb-1">姓名</label>
        <input type="text" v-model="name" class="w-full border rounded p-2" />
      </div>
      <div class="mb-3">
        <label class="block mb-1">手機號碼</label>
        <input type="text" v-model="phoneNumber" class="w-full border rounded p-2" />
      </div>
      <div class="mb-3">
        <label class="block mb-1">電子郵件</label>
        <input type="text" v-model="email" class="w-full border rounded p-2" />
      </div>
      <div class="mb-3">
        <label class="block mb-1">密碼</label>
        <input type="password" v-model="password" class="w-full border rounded p-2" />
      </div>
      <button type="submit" class="bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-600">註冊</button>
    </form>
    <div v-if="errorMessage" class="text-red-500 mt-2">{{ errorMessage }}</div>
    <div v-if="successMessage" class="text-green-500 mt-2">{{ successMessage }}</div>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import axios from 'axios'

const name = ref('')
const phoneNumber = ref('')
const email = ref('')
const password = ref('')
const errorMessage = ref('')
const successMessage = ref('')

const handleRegister = async () => {
  errorMessage.value = ''
  successMessage.value = ''
  try {
    const response = await axios.post('http://localhost:8080/api/auth/register', {
      phoneNumber: phoneNumber.value,
      password: password.value
    })
    successMessage.value = '註冊成功！請前往登入'
  } catch (error) {
    errorMessage.value = error.response?.data?.message || '註冊失敗'
  }
}
</script>
