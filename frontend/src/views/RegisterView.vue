<template>
  <div>
    <h2>註冊</h2>
    <form @submit.prevent="register">
      <input v-model="name" placeholder="姓名" required />
      <input v-model="phone" placeholder="手機號碼" required />
      <input v-model="email" placeholder="Email" required />
      <input v-model="password" type="password" placeholder="密碼" required />
      <button type="submit">註冊</button>
    </form>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import axios from 'axios'
import { useRouter } from 'vue-router'

export default {
  data() {
    return {
      form: {
        username: '',
        userphonenumber: '',
        email: '',
        password: '',
        biography: '',
        coverImage: ''
      }
    };
  },
  methods: {
    register() {
      fetch('http://localhost:8080/user', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(this.form)
      })
      .then(res => res.json())
      .then(data => {
        console.log('註冊成功', data);
        alert('註冊成功！');
        // 可以導頁或清空表單
      })
      .catch(err => {
        console.error('錯誤:', err);
        alert('註冊失敗，請檢查資料或後端是否有開');
      });
    }
  }
}

const name = ref('')
const phone = ref('')
const email = ref('')
const password = ref('')
const router = useRouter()

const register = async () => {
  try {
    await axios.post('http://localhost:8080/api/auth/register', {
      phone: phone.value,
      password: password.value,
    })
    alert('註冊成功，請登入')
    router.push('/login')
  } catch (error) {
    alert('註冊失敗')
  }
}
</script>
