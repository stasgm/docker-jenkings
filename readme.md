# Jenkins setup

## Before you start

This instruction uses Linux OS commands, for other OS please google "how to generate ssh..." and where is the .ssh folder.

## Install Docker

### Links

* <https://docs.docker.com/engine/install/ubuntu/>
* <https://www.digitalocean.com/community/tutorials/how-to-install-and-use-docker-on-ubuntu-20-04>

---

## Install Jenkins

### Links

* <https://omarghader.github.io/jenkins-nodejs-configuration/>
* <https://www.cloudbees.com/blog/how-to-install-and-run-jenkins-with-docker-compose>
  
### Steps

  1. Clone a git repo: <https://github.com/stasgm/docker-jenkins>
  2. Generate ssh:
     * In a terminal window run the command: `ssh-keygen -f ~/.ssh/jenkins_agent_key`
     * Provide a passphrase to use with the key (it can be empty)
  3. Inside your repo copy and rename **.env.sample** to **.env**
  4. Open **.env** and do the following:
     * Copy content of **~/.ssh/jenkins_agent_key.pub** to **JENKINS_AGENT_SSH_PUBKEY=** variable
     * Create a new local folder fo Jenkins data and the path to **LOCAL_JENKINS_DIR=** variable
  5. Run the command: `docker compose up -d`

### Unlocking Jenkins

  1. Browse to <http://localhost:8081> and wait until the Unlock Jenkins page appears.
  2. From the Jenkins console log output (`docker logs <containter id>`), copy the automatically-generated alphanumeric password (between the 2 sets of asterisks).
  3. On the Unlock Jenkins page, paste this password into the Administrator password field and click Continue.

---

## Add ssh

### Links

* <https://www.jenkins.io/doc/book/using/using-agents/>

### Steps

  1. Browse to <http://localhost:8081/manage/credentials/store/system/domain/_/newCredentials>
  2. Fill in the form:
     * Kind: SSH Username with private key;
     * id: jenkins
     * description: The jenkins ssh key
     * username: jenkins
     * Private Key: select Enter directly and press the Add button to insert the content of your private key file at **~/.ssh/jenkins_agent_key**
     * Passphrase: fill your passphrase used to generate the SSH key pair (leave empty if you didn’t use one at the previous step)

---

## Add a new node (Jenkins recommendation)

  1. Browse to <http://localhost:8081/computer/>
  2. Click the 'New node' button
  3. Fill the Node/agent name and select the type; (e.g. Name: agent-1, Type: Permanent Agent) click on the Create button
  4. Fill the form:
     * Remote root directory; (e.g.: /home/jenkins/agent-1 )
     * label; (e.g.: agent-1 )
     * Launch method; (e.g.: Launch agents by SSH)
       * Host; (e.g.:  or your IP address)
       * Credentials; (e.g.: jenkins)
       * Host Key verification Strategy; (e.g.: Manually trusted key verification …​ )
  5. Press the Save button and the agent-1 will be registered, but offline for the time being. Click on it.
  6. You may need to click on the trust ssh menu item to start your agent for the first time.
  7. Open the Build-in node configuration <http://localhost:8081/manage/computer/(built-in)/configure> and set the Number of executors to 0 (in order to disable it)

---

## Install NodeJS Plugin

### Links

* <https://plugins.jenkins.io/nodejs/>
* <https://gist.github.com/MethodGrab/1462c5fcfcd4f690add8>
* <https://blog.devgenius.io/integrating-jenkins-with-a-nodejs-project-219d249b1fb2>

### Steps

  1. Open <http://localhost:8081/manage/pluginManager/available> and Install NodeJS Plugin
  2. Go to <http://localhost:8081/manage/configureTools> and scroll down to NodeJS settings
  3. Press the **Add NodeJS** button, select the required NodeJS version and press the **Save** button
  4. Type yarn in **Global npm packages to install** to install Yarn
