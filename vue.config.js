// const { defineConfig } = require('@vue/cli-service')
// module.exports = defineConfig({
//         transpileDependencies: true
//     })

module.exports = { devServer: { proxy: 'http://localhost:4000' } }
    // ，这样就相当于开启了一个代理服务器，devServer所代理的就是vue-cli手脚架原本开启的端口服务器；proxy表示要把数据发送道哪个端口，其中url只需要写到端口号就可以不必写全部路径

// module.exports = merge(prodEnv, {
//     NODE_ENV: '"development"',
//     OPEN_PROXY: true
// })