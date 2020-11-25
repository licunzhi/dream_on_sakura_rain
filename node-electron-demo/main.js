/*
* 导入待用的模块
* app
* BrowserWindow
* */
const { app, BrowserWindow } = require('electron')

/*
* 创建windows窗口
* */
function createWindow () {
    const win = new BrowserWindow({
        width: 800,
        height: 600,
        webPreferences: {
            nodeIntegration: true
        }
    })

    /*加载文件位置*/
    win.loadFile('./dist/index.html')
    /*开启调试模式*/
    win.webContents.openDevTools()
}

/*初始化完成创建windows窗口*/
app.whenReady().then(createWindow)

/*监听退出操作事件*/
app.on('window-all-closed', () => {
    if (process.platform !== 'darwin') {
        app.quit()
    }
})

/*只有当应用程序激活后没有可见窗口时，才能创建新的浏览器窗口*/
app.on('activate', () => {
    if (BrowserWindow.getAllWindows().length === 0) {
        createWindow()
    }
})
