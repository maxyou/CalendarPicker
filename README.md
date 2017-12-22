# Calendar Picker

Calendar Picker

---

Can preset a selected day. Can customize almost all text size, color, bg color, and month title.


[demo apk](https://github.com/maxyou/CalendarPicker/blob/master/example-release.apk?raw=true)<br>

![pic][1]

  [1]: https://raw.githubusercontent.com/maxyou/CalendarPicker/master/ezgif.com-resize.gif


  Add it in your root build.gradle at the end of repositories:

    allprojects {
      repositories {
        ...
        maven { url 'https://jitpack.io' }
      }
    }

  Add the dependency:

    dependencies {
        compile 'com.github.maxyou:CalendarPicker:v1.0.3'
    }


  Only new a dialog:<br>

    Builder builder = new Builder(MainActivity.this, new Builder.CalendarPickerOnConfirm() {
                @Override
                public void onComplete(YearMonthDay yearMonthDay) {
                    MyConfig.uiToast("You pick "+yearMonthDay.year+"-"+yearMonthDay.month+"-"+yearMonthDay.day);
                }
            })
                    .setPromptText("选择一个日期")
                    .setPromptSize(18)
                    .setPromptColor(Color.RED)
                    .setPromptBgColor(0xFFFFFFFF)

                    .setSelectedText("已选")
                    .setSelectedSize(14)
                    .setSelectedColor(Color.WHITE)
                    .setSelectedBgColor(0xFF1E90FF)

                    .setTodayText("今天")
                    .setTodaySize(14)
                    .setTodayColor(Color.DKGRAY)
                    .setTodayBgColor(Color.YELLOW)

                    .setMonthTitle(new Builder.FormatMonthTitle() {
                        @Override
                        public String setMonthTitle(int year, int month) {
                            return ""+year+"年"+month+"月";
                        }
                    })
                    .setMonthTitleSize(16)
                    .setMonthTitleColor(0xFFB22222)
                    .setMonthTitleBgColor(0x00000000)

                    .setWeekIndex(new String[]{"一", "二", "三", "四", "五", "六", "日"})
                    .setWeekIndexSize(16)
                    .setWeekIndexColor(0xFFFF00FF)
                    .setWeekIndexBgColor(0x00000000)

                    .setCancelText("取消")
                    .setCancelSize(14)
                    .setCancelColor(Color.RED)
                    .setCancelBgColor(0xFFFFFFFF)

                    .setConfirmText("确定")
                    .setConfirmSize(14)
                    .setConfirmColor(Color.RED)
                    .setConfirmBgColor(0xFFB0E0E6)

                    .setPreset(new YearMonthDay(2017, 11, 4))
                    .setDaySize(16)
                    .setDayColor(Color.BLUE)
                    .setDayOtherMonthColor(0xFF87CEFA)
                    .setMonthBaseBgColor(0xFFD0EED0)

                    .setJump2Preset(true)
//                        .restoreDefault()
                    ;

            builder.show();


## License<br>
under [MIT License](http://www.opensource.org/licenses/MIT).
