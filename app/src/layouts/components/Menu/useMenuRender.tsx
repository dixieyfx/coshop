import { MenuItem, SubMenu } from '@arco-design/web-vue'
import type { RouteRecordRaw } from 'vue-router'
import { useRouter } from 'vue-router'
import { routes } from 'vue-router/auto/routes'
import { useBasicSettingStore } from '~/store'

export default function useMenuRender() {
  const router = useRouter()
  const basicSettingStore = useBasicSettingStore()

  function retrieveMenuKeys() {
    const { currentRoute } = router
    basicSettingStore.updateSidebarMenuKeys(
      'selectedKeys',
      currentRoute.value.name as string,
    )
  }

  function menuRender() {
    function renderSubMenu(route: RouteRecordRaw, slots: Record<string, any>) {
      return <SubMenu key={route.name as string}>{slots}</SubMenu>
    }

    function renderMenuItem(route: RouteRecordRaw) {
      !basicSettingStore.isSelectedKeysSet
      && basicSettingStore.updateSidebarMenu({
        selectedKeys: [route.name as string],
      })
      return (
        <MenuItem
          onClick={() => {
            basicSettingStore.updateSidebarMenuKeys(
              'selectedKeys',
              route.name as string,
            )
          }}
          key={route.name as string}
        >
          {route.meta?.title}
        </MenuItem>
      )
    }

    function renderRoutes(_routes: RouteRecordRaw[]): Element[] {
      function renderRoute(route: RouteRecordRaw) {
        if (!route.meta)
          return
        if (route.children) {
          return renderSubMenu(route, {
            icon() {
              return route.meta?.icon
            },
            title() {
              return route.meta?.title
            },
            default() {
              return renderRoutes(route.children ?? [])
            },
          })
        }
        return renderMenuItem(route)
      }

      const routes = _routes
        .map(renderRoute)
        .filter(i => !!i) as unknown as Element[]

      return routes
    }

    return renderRoutes(routes)
  }

  return {
    menuRender,
    retrieveMenuKeys,
  }
}
