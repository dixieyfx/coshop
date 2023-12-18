import { defineStore } from 'pinia'

const useBasicSettingStore = defineStore('basicSetting', () => {
  const sidebarMenu = ref({
    openKeys: [] as string[],
    selectedKeys: [] as string[],
    collapse: false,
  })
  const header = ref({
    height: 60,
  })
  const isSelectedKeysSet = computed(() => {
    return sidebarMenu.value.selectedKeys.length !== 0
  })
  const headerHeight = computed(() => {
    return header.value.height
  })
  const updateSidebarMenu = (config: {
    openKeys?: string[]
    selectedKeys?: string[]
    collapse?: boolean
  }) => {
    Object.assign(sidebarMenu.value, config)
  }
  const updateSidebarMenuKeys = (type: 'openKeys' | 'selectedKeys', key: string) => {
    sidebarMenu.value[type][0] = key
  }
  return {
    sidebarMenu,
    header,
    isSelectedKeysSet,
    headerHeight,
    updateSidebarMenu,
    updateSidebarMenuKeys,
  }
})

export default useBasicSettingStore
