import Request from '~/api'

export const loginAPI = {
  login(data: any) {
    return Request.post('/user/login', data)
  },
  getUserInfo(data: any) {
    return Request.post('/user/admin/findByUsername', data)
  },
  logout(data: any) {
    return Request.post('/logout', data)
  },
}
