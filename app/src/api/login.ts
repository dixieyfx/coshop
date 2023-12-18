import { post } from '.'

export const loginAPI = {
  login: (data: any) => {
    return post('/login', data)
  },
  logout: () => {
    return post('/logout')
  },
}
