<script lang="ts" setup>
// import {Message} from '@arco-design/web-vue'
// import {useUserStore} from '~/store'

// const userStore = useUserStore()
// const router = useRouter()

const userInfo = ref({
  username: 'admin',
  password: 'admin',
})
const loading = ref(false)
const loginFormRef = ref()
async function handleSubmit() {
  // loading.value = true
  // if(errors) {
  //   loading.value = false
  //   return
  // }
  // loading.value = false
  // const res = await userStore.login(userInfo.value)
  // Message.success('登录成功')
  // router.push('/order')
}
</script>

<template>
  <div class="w100%">
    <h2 class="mb16px text-size-24px">
      登录
    </h2>
    <a-form ref="loginFormRef" :model="userInfo" layout="vertical" @submit="handleSubmit">
      <a-form-item
        field="username"
        :rules="[{ required: true, message: ('login.form.userName.errMsg') }]"
        :validate-trigger="['change', 'blur']"
        hide-label
      >
        <a-input v-model="userInfo.username" placeholder="(login.form.userName.placeholder)" @keyup.enter="handleSubmit">
          <template #prefix>
            <icon-user />
          </template>
        </a-input>
      </a-form-item>
      <a-form-item
        field="password"
        :rules="[{ required: true, message: ('请输入密码') }]"
        :validate-trigger="['change', 'blur']"
        hide-label
      >
        <a-input-password
          v-model="userInfo.password"
          placeholder="(请输入密码)"
          allow-clear
          @keyup.enter="handleSubmit"
        >
          <template #prefix>
            <icon-lock />
          </template>
        </a-input-password>
      </a-form-item>
      <a-space :size="16" direction="vertical">
        <a-button type="primary" html-type="submit" long :loading="loading">
          登录
        </a-button>
      </a-space>
    </a-form>
  </div>
</template>
