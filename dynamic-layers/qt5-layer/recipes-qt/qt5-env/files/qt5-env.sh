#!/bin/sh

export PATH=${PATH}:/usr/bin/qt5

export QT_QPA_PLATFORM=linuxfb
export QT_QPA_FB_DRM=1

# to use evdev input
export QT_QPA_FB_NO_LIBINPUT=1
export QT_QPA_EVDEV_TOUCHSCREEN_PARAMETERS=/dev/input/event0:rotate=180

# to use tslib for input (no multi-touch) + qtbase must be compiled with tslib support
# export QT_QPA_FB_TSLIB=1
# export TSLIB_TSDEVICE=/dev/input/touchscreen0

if [ -z "${XDG_RUNTIME_DIR}" ]; then
    export XDG_RUNTIME_DIR=/tmp/user/${UID}

    if [ ! -d ${XDG_RUNTIME_DIR} ]; then
        mkdir -p ${XDG_RUNTIME_DIR}
    fi
fi
