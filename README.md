<p align=center><h2 align=center><strong>坦克大战</strong></h2><i><p align=center>又一个浪费时间的游戏</p></i></p>

> - [骑士飞行棋](https://github.com/ourfor/Game_java/tree/chess)
> - [坦克大战](https://github.com/ourfor/Game_java/tree/tank)

---


![坦克](https://i.loli.net/2018/11/14/5bec1a568de72.png)

>
- 自顶向下
- 逐步求精
- 模块化设计
- 结构化编码

- [x] 适配器模式
- [x] 桥接模式
- [x] 建造者模式
- [x] 组合模式

> 键盘布局修改(此布局更适合游戏玩家)

![](https://i.loli.net/2018/11/26/5bfb896ddacaa.png)

- 增加4个不同的方位键(坦克移动方向、速度以及子弹移动方向)
- 修改窗口键盘的键位提示信息(GameFrame中修改提示信息，可考虑将键位设置写进xml配置文件)
- 修复坦克可以穿过河流下方的bug(River中修改河流图片的像素)

> 已知Bug

- 血包出现在坦克不能到达的区域
- 重新开始游戏会出现两个窗口，这个应该是一个较大的bug
- 在某些设备上会出现菜单栏的不可映射字符
- 敌方坦克可以穿过金属墙
- 赢了之后，进攻老巢，依旧判定为输
- 输了之后，敌方坦克数量显示为0，不会显示输的信息
