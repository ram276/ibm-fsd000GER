const server = require('express').Router();
const UserService = require('../services/user.service').UserService;
const userService = new UserService();
const SecurityService = require('../services/security.service').SecurityService;
const securityService = new SecurityService();
// apis
server.get('/status', (rq, rs) => {
    rs.status(200).json({
        message: 'Security Service is Running'
    });
});
// sign up
server.post('/register', (rq, rs) => {
    userService.addUser(rq.body, (err, res) => {
        if (err) {
            rs.status(402).json({
                message: 'Unable to proceess the request',
                trace: err
            });
        } else {
            rs.status(200).json({
                message: 'User created successfully',
                users: res
            });
        }
    });
});

// generate new token
server.post('/token', (rq, rs) => {
    if (rq.body.email == undefined || rq.body.password == undefined) {

        rs.status(401).json({
            message: 'Please specify valid '
        });
    } else {
        userService.fetchUser(rq.body.email, rq.body.password, (err, res) => {
            console.log(res);
            if (err) {

                rs.status(401).json({
                    message: 'Please specify credentials'

                });
            } else {
                if (res != undefined && res.length > 0) {
                    // generate jwt token

                    const _token = securityService.generateToken({
                        email: res[0].email,
                        access: res[0].access
                    });
                    const _user = {
                        id: 1,
                        token: _token,
                        email: res[0].email,
                        access: res[0].access
                    }
                    securityService.saveToken(_user, (err, data) => {
                        if (err) {
                            rs.status(401).json({
                                message: 'Unable to process your request'
                            });
                        } else {
                            rs.status(200).json({
                                message: 'Token Generated Successfully',
                                token: _token
                            });
                        }
                    });
                } else {
                    rs.status(401).json({
                        message: 'specify valid credentials'
                    });
                }
            }
        });
    }
});

server.post('/token/refresh', (rq, rs) => {
    if (rq.body.token == undefined) {
        rs.status(401).json({
            message: 'Please specify a valid token'
        });
    } else {
        securityService.refreshToken(rq.body.token, (err, data) => {
            if (err) {
                rs.status(403).json({
                    message: 'Token expired or Invalid'
                });
            } else {
                // generate jwt token
                const _token = securityService.generateToken(data);
                const _user = {
                    id: 1,
                    token: _token,
                    email: data[0].email,
                    access: data[0].access
                }
                securityService.saveToken(_user, (err, data) => {
                    if (err) {
                        rs.status(401).json({
                            message: 'Unable to process your request'
                        });
                    } else {
                        rs.status(200).json({
                            message: 'Token refreshed Successfully',
                            refreshToken: _token
                        });
                    }
                });
            }
        });
    }
});
// redirect in case of invalid / no access
server.get('/unauthorize', (rq, rs) => {
    rs.status(403).json({
        message: 'Unauthorize Access'
    });
});
server.post('/verifyOtp', (rq, rs) => {
    userService.fetchUser(rq.body.email, rq.body.otp, (err, res) => {
        console.log(res);
        if (err) {

            rs.status(401).json({
                message: 'Please specify credentials'

            });
        } else {
            if (res.length > 0) {
                rs.status(201).json({
                    message: 'success'
                })
            } else {
                rs.status(401).json({
                    message: 'specify valid otp'
                });
            }
        }
    })

})
module.exports = {
    server
}