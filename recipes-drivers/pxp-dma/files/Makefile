obj-m := pxp-dma.o
pxp-dma-objs := pxp_dma_v3.o pxp_device.o

KVERSION = $(shell uname -r)
SRC := $(shell pwd)

#KCPPFLAGS="-DCONFIG_MXC_PXP_CLIENT_DEVICE"

all:
#	make -C /lib/modules/$(KVERSION)/build M=$(SRC) modules
	$(MAKE) -C $(KERNEL_SRC) M=$(SRC)

modules_install:
	$(MAKE) -C $(KERNEL_SRC) M=$(SRC) modules_install

clean:
#	make -C /lib/modules/$(KVERSION)/build M=$(SRC) clean

	rm -f *.o *~ core .depend .*.cmd *.ko *.mod.c
	rm -f Module.markers Module.symvers modules.order
	rm -rf .tmp_versions Modules.symvers
