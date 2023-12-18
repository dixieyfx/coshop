<script setup lang='ts'>
import {
  Layout,
  LayoutContent,
  LayoutHeader,
  LayoutSider,
} from '@arco-design/web-vue'
import Header from './components/Header/index.tsx'
import Menu from './components/Menu/index.tsx'
import { useBasicSettingStore } from '~/store'

const basicSetting = useBasicSettingStore()
</script>

<template>
  <main
    text="center gray-700 dark:gray-200"
    class="h100% w100%"
  >
    <Layout class="h100% w100%">
      <LayoutHeader>
        <Header />
      </LayoutHeader>
      <Layout>
        <LayoutSider :collapsed="basicSetting.sidebarMenu.collapse">
          <Menu />
        </LayoutSider>
        <LayoutContent>
          <RouterView />
        </LayoutContent>
      </Layout>
    </Layout>
  </main>
</template>
