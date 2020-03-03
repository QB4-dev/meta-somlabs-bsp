meta-somlabs-bsp
==

Basic SoMLabs Yocto meta-layer - intended to be easy to use as VisionSOM-6ULL projects base

#### Layer Features:
- Somlabs U-Boot bootloader support with SD/NAND/EMMC auto recognition, USB flashing mode and custom splash screen
- U-Boot fw-utils support
- Fairly new Linux-fslc kernel from meta-freescale support 
- Kernel device-tree structure prepared to be easily inherited by another layers(SOM module/Carrier board levels)  
- Murata 1DX Wifi and Bluetooth module support Out-of-Box
- QT5 support with evdev/tslib touch panel/keyboard + gstreamer backend for qtmultimedia
- SOMLabs SL-TFT7-TP-800-480-P LCD+Touch panel support
- PXP support for gstreamer hardware acceleration - pxp-dma-v3 driver ported from `-imx` kernel family [WIP]
- gstreamer PXP plugins support 
- Proper sleep/wakeup support

Demo Layer available here:
https://github.com/QB4-dev/meta-somlabs-demo

Build Instructions
==

Tools
----

On fresh Linux OS installation use this command to install tools needed by Yocto:

```
sudo apt-get install gawk wget git-core diffstat unzip texinfo gcc-multilib \
build-essential chrpath socat cpio python python3 python3-pip python3-pexpect \
xz-utils debianutils iputils-ping python3-git python3-jinja2 libegl1-mesa libsdl1.2-dev \
xterm
```

[more info...](https://www.yoctoproject.org/docs/2.7/ref-manual/ref-manual.html#required-packages-for-the-build-host)


Bulid environment
----

Open terminal window and run following commands:

- create yocto root directory

```
mkdir yocto
cd yocto
```
- create build directory inside:
```
mkdir visionsom_build
```
- download poky - reference Yocto Linux Distribution
```
git clone -b zeus git://git.yoctoproject.org/poky.git poky
cd poky
```
- download essential layers
```
git clone -b zeus git://git.openembedded.org/meta-openembedded
git clone -b zeus https://github.com/Freescale/meta-freescale.git
git clone -b zeus https://github.com/QB4-dev/meta-somlabs-bsp
```
Init bulid environment
```
source ./oe-init-build-env ../visionsom_build/
```
Bulid configuration
----

**local.conf**

Edit `yocto/visionsom_build/conf/local.conf` file, You can use `/conf/local.conf.sample` from **meta-somlabs-bsp** layer as a [template](https://github.com/QB4-dev/meta-somlabs-bsp/blob/master/conf/local.conf.sample)

- select proper machine:
`MACHINE ??= "visionsom6ull-wifi-cb-std"`
and DISTRO
`DISTRO ?= "poky"`
> You can choose between VisionSOM6ULL with or without WiFi module on VisionCB-STD form machine configs defined here:
> https://github.com/QB4-dev/meta-somlabs-bsp/tree/master/conf/machine

**bblayers.conf**

Edit `yocto/visionsom_build/conf/bblayers.conf` file, You can use `/conf/bblayers.conf.sample` from **meta-somlabs-bsp** layer as a [template](https://github.com/QB4-dev/meta-somlabs-bsp/blob/master/conf/bblayers.conf.sample)

Recommended layers list:
```
YOCTO_ROOT = "${@os.path.abspath(os.path.join("${TOPDIR}", os.pardir))}"

BBLAYERS ?= " \
  ${YOCTO_ROOT}/poky/meta \
  ${YOCTO_ROOT}/poky/meta-poky \
  ${YOCTO_ROOT}/poky/meta-openembedded/meta-oe \
  ${YOCTO_ROOT}/poky/meta-openembedded/meta-networking \
  ${YOCTO_ROOT}/poky/meta-openembedded/meta-python \
  ${YOCTO_ROOT}/poky/meta-freescale \
  ${YOCTO_ROOT}/poky/meta-somlabs-bsp \
  "
```

Build process
----
Go back to `yocto/visionsom_build` directory and run:
```
bitbake core-image-minimal
```

> First build will take a few hours depending on your host PC hardware

Flashing Linux image
--

To flash complete image onto SD card go to `yocto/visionsom_build/tmp/deploy/images/visionsom6ull-wifi-cb-std`
insert your SD card and find card id using `lsblk` or `dmesg` cmd:

```
sda           8:0    0 465,8G  0 disk 
├─sda3        8:3    0   9,7G  0 part [SWAP]
├─sda4        8:4    0  60,4G  0 part /media/projects
└─sda7        8:7    0 113,4G  0 part /mnt/yocto
sdb           8:16   0 119,2G  0 disk 
├─sdb1        8:17   0  55,9G  0 part /
└─sdb2        8:18   0  55,9G  0 part /home
mmcblk0     179:0    0   1,9G  0 disk 
└─mmcblk0p1 179:1    0 269,7M  0 part /media/mmc
```
In this example our sd card has been recognized as `/dev/mmcblk0`

## NOTE: Double-check sd card identifier, wrong identifier can damage data on your host drive!!! 

Flash image using `gunzip` and `dd` tools:
```
gunzip -c core-image-minimal-visionsom6ull-wifi-cb-std.wic.gz | sudo dd of=/dev/mmcblk0 bs=1M iflag=fullblock oflag=direct conv=fsync status=progress
```
Insert card inside Your board and connect power supply

For EMMC/NAND board versions refer to:

https://wiki.somlabs.com/index.php/How_to_write_image_to_VisionSOM-6ULL_eMMC_on_Windows_and_Linux
https://wiki.somlabs.com/index.php/How_to_write_image_to_VisionSOM-6ULL_NAND_memory_using_UUU_tool_on_Linux

Happy coding







