import Request from '~/hooks/request'

export default new Request({
  baseURL: '/api',
  timeout: 30000,
})

export function get(url: string, data?: any) {
  return new Request({ url, method: 'get', params: data || {} })
}
export function post(url: string, data?: any) {
  return new Request({ url, method: 'post', data: data || {} })
}
