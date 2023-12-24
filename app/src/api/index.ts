import Request from '~/hooks/request'

export default new Request({
  baseURL: '/api',
  timeout: 30000,
})

