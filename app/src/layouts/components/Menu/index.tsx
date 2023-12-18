import useMenuRender from './useMenuRender'
import { useBasicSettingStore } from '~/store'

export default defineComponent({
  setup() {
    const basicSettingStore = useBasicSettingStore()
    const { menuRender, retrieveMenuKeys } = useMenuRender()

    onBeforeMount(() => {
      retrieveMenuKeys()
    })

    return () => {
      return (
        <a-menu
          class="h100%"
          breakpoint="xl"
          auto-open
          auto-open-selected
          onCollapse={(collapse: boolean) =>
            basicSettingStore.updateSidebarMenu({
              collapse,
            })}
          v-model:selected-keys={basicSettingStore.sidebarMenu.selectedKeys}
          show-collapse-button
        >
          {menuRender()}
        </a-menu>
      )
    }
  },
})
