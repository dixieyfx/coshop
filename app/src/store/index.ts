import { createPinia } from 'pinia'
import useUserStore from './modules/user'
import useBasicSettingStore from './modules/basicSetting'

const pinia = createPinia()

export {
  useUserStore,
  useBasicSettingStore,
}

export default pinia
