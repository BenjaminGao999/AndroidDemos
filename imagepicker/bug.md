## 点击任意一个item，在返回，gridActivity空了

https://github.com/jeasonlzy/ImagePicker/issues/243

因为v7包27后LoaderManager加了lifecycle
所以当Activity onResume的时候onLoadFinished会再回调一次。
而这次cursor的数据已经移到最后一行了cursor.hasNext为false数据就清空了。

* 解决方案
在while前将cursor移动到第一行，就ok了。
if(!data.moveToFirst()){ return; }

