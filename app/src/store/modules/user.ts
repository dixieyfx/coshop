import { defineStore } from 'pinia'
import { loginAPI } from '~/api/login'

interface ILoginInfo {
  username: string
  password: string
}
const useUserStore = defineStore('user', () => {
  async function login(loginInfo: ILoginInfo) {
    const res = await loginAPI.login(loginInfo)
    console.log("🚀 ~ file: user.ts:11 ~ login ~ res:", res)
    if(res.isSuccess()) {
      // setToken(res.token)
      // setUserInfo(res.userInfo)
      // setRole(res.role)
      console.log('logined')
    }
  }

  return { login }
})
export default useUserStore
