// index.js
var myBehavior = require("../../utils/my-behaviors.js")
var common = require("../../utils/common.js")
// 获取应用实例
const app = getApp()

Page({
  behaviors: [myBehavior],
  data: {
    motto: 'Hello World',
    userInfo: {},
    message:"Hello World!",
    hasUserInfo: false,
    canIUse: wx.canIUse('button.open-type.getUserInfo'),
    canIUseGetUserProfile: false,
    canIUseOpenData: wx.canIUse('open-data.type.userAvatarUrl') && wx.canIUse('open-data.type.userNickName') // 如需尝试获取用户信息可改为false
  },
  data1:{
    msg:'testtest'
  },
  showData(){
    let msg = this.data1.msg;
    this.setData({
      msg:msg
    })
  },
  // 事件处理函数
  bindViewTap() {
    wx.navigateTo({
      // url: '../logs/logs'
      url: '../test/test'
    })
  },
  onLoad() {
    console.log("恭喜你，页面创建了，执行了onLoad()方法")
    if (wx.getUserProfile) {
      this.setData({
        canIUseGetUserProfile: true
      })
    }
    common.sayGoodabye();
  },
  onShow(){
    console.log("恭喜你，页面出现在前台，执行了onShow()方法")
  },
  getUserProfile(e) {
    // 推荐使用wx.getUserProfile获取用户信息，开发者每次通过该接口获取用户个人信息均需用户确认，开发者妥善保管用户快速填写的头像昵称，避免重复弹窗
    wx.getUserProfile({
      desc: '展示用户信息', // 声明获取用户个人信息后的用途，后续会展示在弹窗中，请谨慎填写
      success: (res) => {
        console.log(res)
        this.setData({
          userInfo: res.userInfo,
          hasUserInfo: true
        })
      }
    })
  },
  getUserInfo(e) {
    // 不推荐使用getUserInfo获取用户信息，预计自2021年4月13日起，getUserInfo将不再弹出弹窗，并直接返回匿名的用户个人信息
    console.log(e)
    this.setData({
      userInfo: e.detail.userInfo,
      hasUserInfo: true
    })
  }
})
