import avatar from '~/assets/avatar.png'
import Logo from '~/assets/logo.svg'

export default defineComponent({
  setup(_) {
    return () => {
      return (
        <div class="h-60px min-w-210px flex items-center px-16px py-0 justify-between font-bold bg-#fff">
          <div class="flex items-center gap-12px">
            <div class="w32px h32px">
              <Logo />
            </div>
            <span class="text-size-22px font-700">Coffee Life</span>
          </div>
          <div>
            <img class="border border-solid border-#ccc w32px h32px b-rd-50% cursor-pointer" src={avatar} />
          </div>
        </div>
      )
    }
  },
})
