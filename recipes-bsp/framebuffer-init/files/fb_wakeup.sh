#!/bin/sh
### BEGIN INIT INFO
# Provides: framebuffer display wakeup
# Required-Start:
# Required-Stop:
# Default-Start:     S
# Default-Stop:
### END INIT INFO

#exit if framebuffer unavailable
[ ! -e /dev/fb0 ] && exit 0;
#wake up display panel
echo 0 > /sys/class/graphics/fb0/blank

