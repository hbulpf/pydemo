import os
import pwd
import grp
import time
import sys

class ListDir(object):
    def __init__(self, path):
        self.path = path
        self.file_pri = {"7": "rwx", "6": "rw-", "5": "r-x", "4": "r--",
                         "3": "-wx", "2": "-w-", "1": "--x", "0": "---", "d": "d", "f": "-"}
    def get_attr(self, file):
        self.f_attr = os.stat(file)
        if os.path.isfile(file):
            self.f = "f"
            self.f_ = "."
        else:
            self.f = "d"
            self.f_ = ""
        self.a = self.file_pri[str(oct(self.f_attr.st_mode)[-3:])[0]]+self.file_pri[str(
            oct(self.f_attr.st_mode)[-3:])[1]]+self.file_pri[str(oct(self.f_attr.st_mode)[-3:])[2]]
        self.st_nlink = str(self.f_attr.st_nlink)
        self.st_size = str(self.f_attr.st_size)
        if time.strftime("%Y", time.localtime(self.f_attr.st_mtime)) == time.strftime("%Y", time.localtime()):
            self.st_mtime = time.strftime(
                "%b %d %H:%M", time.localtime(self.f_attr.st_mtime))
        else:
            self.st_mtime = time.strftime(
                "%b %d %Y", time.localtime(self.f_attr.st_mtime))
        try:
            self.pw_name = pwd.getpwuid(self.f_attr.st_uid).pw_name
            self.gr_name = grp.getgrgid(self.f_attr.st_gid).gr_name
        except Exception as e:
            self.pw_name = str(self.f_attr.st_uid)
            self.gr_name = str(self.f_attr.st_gid)
        print((self.file_pri[self.f]+self.a+self.f_).ljust(11), end="")
        print(self.st_nlink.rjust(3), end="")
        print(self.pw_name.rjust(5), end="")
        print(self.gr_name.rjust(5), end="")
        print(self.st_size.rjust(9), end="")
        print(self.st_mtime.rjust(13), end="")
        print("", file)

def main(path="."):
    f = ListDir(path)
    os.chdir(path)
    for i in os.listdir("."):
        if i[0] == ".":
            continue
        f.get_attr(i)

if __name__ == "__main__":
    if len(sys.argv) > 1:
        if not os.path.isfile(str(sys.argv[1])) and not os.path.isdir(str(sys.argv[1])):
            print(str(sys.argv[1])+" dir or file not found.")
            exit()
        main(str(sys.argv[1]))
    else:
        main()
