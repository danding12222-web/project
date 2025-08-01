<template>
  <div>
    <h2>登入</h2>
    <form @submit.prevent="login">
      <input v-model="phone" placeholder="手機號碼" required />
      <input v-model="password" type="password" placeholder="密碼" required />
      <button type="submit">登入</button>
    </form>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import axios from 'axios'
import { useRouter } from 'vue-router'

const phone = ref('')
const password = ref('')
const router = useRouter()

const login = async () => {
  try {
    const res = await axios.post('http://localhost:8080/api/auth/login', {
      phone: phone.value,
      password: password.value,
    })
    localStorage.setItem('token', res.data.token)
    alert('登入成功')
    router.push('/')
  } catch (error) {
    alert('登入失敗')
  }
}
</script>
