# coding=utf-8
import time
from selenium import webdriver
from selenium.common.exceptions import NoSuchElementException
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.wait import WebDriverWait


# 进入 baidu 首页作为例子
def baiduHome():
    browser = webdriver.Chrome()
    browser.get("http://www.baidu.com")
    #########百度输入框的定位方式##########
    # 通过id方式定位
    browser.find_element_by_id("kw").send_keys("selenium")
    # 通过name方式定位
    browser.find_element_by_name("wd").send_keys("selenium")
    # 通过tag name方式定位
    browser.find_element_by_tag_name("input").send_keys("selenium")
    # 通过class name方式定位
    browser.find_element_by_class_name("s_ipt").send_keys("selenium")
    # 通过CSS方式定位
    browser.find_element_by_css_selector("#kw").send_keys("selenium")
    # 通过xpath方式定位
    browser.find_element_by_xpath("//input[@id='kw']").send_keys("selenium")
    browser.find_element_by_id("su").click()
    time.sleep(3)
    browser.quit()


# 浏览器无界面启动
def headless():
    chrome_options = webdriver.ChromeOptions()
    # 使用headless无界面浏览器模式
    chrome_options.add_argument('--headless')  # 增加无界面选项
    chrome_options.add_argument('--disable-gpu')  # 如果不加这个选项，有时定位会出现问题
    # 启动浏览器，获取网页源代码
    browser = webdriver.Chrome(chrome_options=chrome_options)
    mainUrl = "https://www.taobao.com/"
    browser.get(mainUrl)
    print(f"browser text = {browser.page_source}")
    browser.quit()


# 登录例子
def loginDemo():
    browser = webdriver.Chrome()
    browser.get('https://www.baidu.com/')
    # 最大化
    browser.maximize_window()
    try:
        # 通过id方式定位
        browser.find_element_by_id("username").clear()
        browser.find_element_by_id("username").send_keys("user1")
        browser.find_element_by_id("password").send_keys("pwd1")
        browser.find_element_by_name("commit").send_keys(Keys.ENTER)
        time.sleep(20)
        browser.find_element_by_class_name("click-to-expand js-click-to-expand").click()
    except NoSuchElementException as err:
        print("error: {0}".format(err.msg))
    # 关闭浏览器
    browser.close()


# 根据类名进行定位
def classDemo():
    driver = webdriver.Chrome()
    driver.get("http://mail.126.com/")
    driver.implicitly_wait(20)

    driver.switch_to.frame("x-URS-iframe")
    # 方法一：取单个class属性
    driver.find_element_by_class_name("dlemail").send_keys("yoyo")
    driver.find_element_by_class_name("dlpwd").send_keys("12333")

    # 方法二：定位一组取下标定位（乃下策）
    driver.find_elements_by_class_name("j-inputtext")[0].send_keys("yoyo")
    driver.find_elements_by_class_name("j-inputtext")[1].send_keys("12333")

    # 方法三：css定位
    driver.find_element_by_css_selector(".j-inputtext.dlemail").send_keys("yoyo")
    driver.find_element_by_css_selector(".j-inputtext.dlpwd").send_keys("123")

    # 方法四：取单个class属性也是可以的
    driver.find_element_by_css_selector(".dlemail").send_keys("yoyo")
    driver.find_element_by_css_selector(".dlpwd").send_keys("123")

    # 方法五：直接包含空格的CSS属性定位大法
    driver.find_element_by_css_selector("[class='j-inputtext dlemail']").send_keys("yoyo")


# 判断元素
def judgeElement():
    driver = webdriver.Chrome()
    driver.get("http://baidu.com")
    # 判断title完全等于
    title = EC.title_is(u'百度')
    print(title(driver))

    # 判断title包含
    title1 = EC.title_contains(u'百度')
    print(title1(driver))

    # 另外一种写法
    r1 = EC.title_is(u'百度')(driver)
    r2 = EC.title_contains(u'百度')(driver)
    print(r1)
    print(r2)


# 强制等待
def forceWait():
    driver = webdriver.Chrome()
    driver.get('http://baidu.com')
    time.sleep(3)  # 强制等待3秒再执行下一步
    print(driver.current_url)
    driver.quit()


# 隐性等待
def implicitlyWait():
    driver = webdriver.Chrome()
    driver.implicitly_wait(30)  # 隐性等待，最长等30秒
    driver.get('http://baidu.com')
    print(driver.current_url)
    driver.quit()


# 显性等待
def explicitlyWait():
    base_url = "http://www.baidu.com"
    driver = webdriver.Chrome()
    driver.implicitly_wait(5)
    '''隐式等待和显示等待都存在时，超时时间取二者中较大的'''
    driver.get(base_url)

    WebDriverWait(driver, 10).until(EC.title_is(u"百度一下，你就知道"))
    '''判断title,返回布尔值'''

    WebDriverWait(driver, 10).until(EC.title_contains(u"百度一下"))
    '''判断title，返回布尔值'''

    WebDriverWait(driver, 10).until(EC.presence_of_element_located((By.ID, 'kw')))
    '''判断某个元素是否被加到了dom树里，并不代表该元素一定可见，如果定位到就返回WebElement'''

    WebDriverWait(driver, 10).until(EC.visibility_of_element_located((By.ID, 'su')))
    '''判断某个元素是否被添加到了dom里并且可见，可见代表元素可显示且宽和高都大于0'''

    WebDriverWait(driver, 10).until(EC.visibility_of(driver.find_element(by=By.ID, value='kw')))
    '''判断元素是否可见，如果可见就返回这个元素'''

    WebDriverWait(driver, 10).until(EC.presence_of_all_elements_located((By.CSS_SELECTOR, '.mnav')))
    '''判断是否至少有1个元素存在于dom树中，如果定位到就返回列表'''

    WebDriverWait(driver, 10).until(EC.visibility_of_any_elements_located((By.CSS_SELECTOR, '.mnav')))
    '''判断是否至少有一个元素在页面中可见，如果定位到就返回列表'''

    WebDriverWait(driver, 10).until(EC.text_to_be_present_in_element((By.XPATH, "//*[@id='u1']/a[8]"), u'设置'))
    '''判断指定的元素中是否包含了预期的字符串，返回布尔值'''

    WebDriverWait(driver, 10).until(EC.text_to_be_present_in_element_value((By.CSS_SELECTOR, '#su'), u'百度一下'))
    '''判断指定元素的属性值中是否包含了预期的字符串，返回布尔值'''

    # WebDriverWait(driver,10).until(EC.frame_to_be_available_and_switch_to_it(locator))
    '''判断该frame是否可以switch进去，如果可以的话，返回True并且switch进去，否则返回False'''
    # 注意这里并没有一个frame可以切换进去

    WebDriverWait(driver, 10).until(EC.invisibility_of_element_located((By.CSS_SELECTOR, '#swfEveryCookieWrap')))
    '''判断某个元素在是否存在于dom或不可见,如果可见返回False,不可见返回这个元素'''
    # 注意#swfEveryCookieWrap在此页面中是一个隐藏的元素

    WebDriverWait(driver, 10).until(EC.element_to_be_clickable((By.XPATH, "//*[@id='u1']/a[8]"))).click()
    '''判断某个元素中是否可见并且是enable的，代表可点击'''
    driver.find_element_by_xpath("//*[@id='wrapper']/div[6]/a[1]").click()
    # WebDriverWait(driver,10).until(EC.element_to_be_clickable((By.XPATH,"//*[@id='wrapper']/div[6]/a[1]"))).click()

    # WebDriverWait(driver,10).until(EC.staleness_of(driver.find_element(By.ID,'su')))
    '''等待某个元素从dom树中移除'''
    # 这里没有找到合适的例子

    WebDriverWait(driver, 10).until(EC.element_to_be_selected(driver.find_element(By.XPATH, "//*[@id='nr']/option[1]")))
    '''判断某个元素是否被选中了,一般用在下拉列表'''

    WebDriverWait(driver, 10).until(
        EC.element_selection_state_to_be(driver.find_element(By.XPATH, "//*[@id='nr']/option[1]"), True))
    '''判断某个元素的选中状态是否符合预期'''

    WebDriverWait(driver, 10).until(
        EC.element_located_selection_state_to_be((By.XPATH, "//*[@id='nr']/option[1]"), True))
    '''判断某个元素的选中状态是否符合预期'''
    driver.find_element_by_xpath(".//*[@id='gxszButton']/a[1]").click()

    instance = WebDriverWait(driver, 10).until(EC.alert_is_present())
    '''判断页面上是否存在alert,如果有就切换到alert并返回alert的内容'''
    print
    instance.text
    instance.accept()
    driver.close()


# forceWait()
# implicitlyWait()
# explicitlyWait()
judgeElement()
# classDemo()
# baiduHome()
# loginDemo()
# headless()
