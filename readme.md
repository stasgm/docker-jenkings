Jenkins setup
==============================

## Before you start

This instruction uses Linux OS commands, for other OS please google "`how to generate ssh...`" and where is the `.ssh` folder.

## Install Docker

### Links

* <https://docs.docker.com/engine/install/ubuntu/>
* <https://www.digitalocean.com/community/tutorials/how-to-install-and-use-docker-on-ubuntu-20-04>

---

## First steps

1. Clone this repo: <https://github.com/stasgm/docker-jenkins>

    ```bash
    git clone https://github.com/stasgm/docker-jenkins
    ```
  
2. Select Jenkins Agent (you can have multiple agents for different purposes)

   * [docker-based agent](/guides/setup-docker-based-agent.md)
   * [ubuntu agent](/guides/setup-ubuntu-agent.md)
   * [mac agent](/guides/setup-mac-agent.md)
   * [windows agent](/guides/setup-windows-agent.md)

3. Inside cloned repo folder, copy and rename **.env.sample** to **.env**
4. Open for editing **.env** and do the following:
     * Copy content of **~/.ssh/jenkins_agent_key.pub** to **JENKINS_AGENT_SSH_PUBKEY=** variable (for running docker-based agent, you can skip it if you don't use a docker based agent)
     * Create a new local folder fo Jenkins data and the path to **LOCAL_JENKINS_DIR=** variable (for storing jenkins data on your master server)
5. Run the command: `docker compose up -d`

6. Unlock Jenkins

   * Browse to <http://localhost:8081> and wait until the Unlock Jenkins page appears.
   * From the Jenkins console log output (`docker logs <containter id>`), copy the automatically-generated alphanumeric password (between the 2 sets of asterisks).
   * On the Unlock Jenkins page, paste this password into the Administrator password field and click Continue.
